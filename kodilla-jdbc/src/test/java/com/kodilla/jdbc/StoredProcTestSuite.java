package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        statement.close();
        statement2.close();
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        // given
        DbManager dbManager = DbManager.getInstance();
        String isBestsellerUpdate = "UPDATE BOOKS SET BESTSELLERS = 0";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(isBestsellerUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLERS > 0";

        // when
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");

        }
        // for Bestsellers
        assertEquals(2, howMany);
        statement.close();
        statement2.close();
    }

}
