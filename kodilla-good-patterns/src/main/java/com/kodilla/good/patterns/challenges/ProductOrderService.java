package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private InformationService informationService;
    private PurchaseService purchaseService;
    private PurchaseRepository purchaseRepository;

    public ProductOrderService(final InformationService informationService,
                               final PurchaseService purchaseService,
                               final PurchaseRepository purchaseRepository) {
        this.informationService = informationService;
        this.purchaseService = purchaseService;
        this.purchaseRepository = purchaseRepository;
    }

    public TransactionDto process(final PurchaseRequest purchaseRequest){
        boolean sold = purchaseService.buy(purchaseRequest.getBuyer(),
                purchaseRequest.getTransactionDateTime(),
                purchaseRequest.getProduct());
        if(sold){
            informationService.inform(purchaseRequest.getBuyer());
            purchaseRepository.createPurchase(purchaseRequest.getBuyer(),
                    purchaseRequest.getTransactionDateTime(),
                    purchaseRequest.getProduct().getPrice());
            return new TransactionDto(purchaseRequest.getBuyer(), true);
        } else {
            return new TransactionDto(purchaseRequest.getBuyer(), false);
        }
    }
}
