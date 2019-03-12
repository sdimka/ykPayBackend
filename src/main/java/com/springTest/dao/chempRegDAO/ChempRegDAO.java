package com.springTest.dao.chempRegDAO;

import com.springTest.model.chempReg.ChempReg;

import java.util.List;

public interface ChempRegDAO {

    ChempReg get(long id);

    List<ChempReg> list();

    long save(ChempReg chempReg);

    void updatePaymentId(long id, String newPaymentID);

}
