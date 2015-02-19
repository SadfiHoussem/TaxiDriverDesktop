/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.DAO.interfaces;

import edu.esprit.entities.Client;
import java.util.List;

/**
 *
 * @author Houssem
 */
public interface IClientDAO {
    
    boolean insertClient(Client client);
    boolean updateClient(Client client);
    boolean deleteClient(int id);
    boolean isClientExist(Client c); 
    boolean isClientExistUpdate(Client c);
    Client findClientById(int id);
    Client findClientByCin(Long cin);
    boolean findClientByLogin_PWD(String login, String pwd);
    List<Client> DisplayAllClients();
    
}
