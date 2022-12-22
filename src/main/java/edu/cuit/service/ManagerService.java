package edu.cuit.service;

import edu.cuit.domain.Manager;

import java.util.List;

public interface ManagerService {
    public Manager findMByusername(String musername);

    public void UpdateInfo(Manager manager);

    public List<Manager> findAll();

    public void insertManager(Manager manager);

    public void deleteByMusername(String musername);
}
