package com.objis.spring.demodao;

import com.objis.spring.demodomaine.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @author Jimmy Rakotoson, José-Alexandre Giry
 *
 */

public interface IClientDao extends JpaRepository<Client, Integer> {

    List<Client> findByNomContaining(String keyword);

}