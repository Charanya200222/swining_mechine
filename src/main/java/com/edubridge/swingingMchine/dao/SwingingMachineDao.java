package com.edubridge.swingingMchine.dao;

import java.util.List;

import com.edubridge.swingingMchine.model.SwingingMachine;

public interface SwingingMachineDao {
	int addSwingingMachine(SwingingMachine s);
    List<SwingingMachine> getAllSwingingMachines();
    SwingingMachine getSwingingMachine(String name);
    int updateSwingingMachine(SwingingMachine s);
    int deleteSwingingMachine(String name);
    void deleteAllSwingingMachines();
	

}
