package com.ecommerce.microcommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.microcommerce.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	@Query("SELECT id, nom, prix FROM Product p WHERE p.prix > :prixLimit")
	List<Product> chercherUnProduitCher(@Param("prixLimit") int prix);

	Product findById(int id);

	List<Product> findByNomLike(String recherche);

	List<Product> findByPrixGreaterThan(int prixLimit);

	@Query("SELECT id, nom, prix, prixAchat FROM Product p ORDER BY nom")
	List<Product> trierProduitsParOrdreAlphabetique();

}
