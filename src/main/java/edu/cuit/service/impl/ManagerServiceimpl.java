package edu.cuit.service.impl;

import edu.cuit.domain.Manager;
import edu.cuit.mapper.ManagerMapper;
import edu.cuit.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ManagerService")
public class ManagerServiceimpl implements ManagerService {
    @Autowired
    ManagerMapper managerMapper;



    @Override
    public Manager findMByusername(String musername){
        return managerMapper.findByMusername(musername);
    }

    @Override
    public void UpdateInfo(Manager manager){
        managerMapper.update(manager);
    }

    @Override
    public List<Manager> findAll(){
        return managerMapper.findAll();
    }

    @Override
    public void insertManager(Manager manager){
        managerMapper.save(manager);
    }

    @Override
    public void deleteByMusername(String musername){
        managerMapper.deleteByMusername(musername);
    }
}
