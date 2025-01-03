package com.example.Lab1TBD.persistence.repositories;

import com.example.Lab1TBD.persistence.entities.CustomerOpinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CustomerOpinionRepositoryImp implements CustomerOpinionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public CustomerOpinion findCustomerOpinionById(Long opinion_id){
        String query = "SELECT * FROM opinions WHERE opinion_id = :opinion_id";
        try(Connection con = sql2o.open()){
            return con.createQuery(query)
                    .addParameter("opinion_id",opinion_id)
                    .executeAndFetchFirst(CustomerOpinion.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico en caso de error
        }
    }

    @Override
    public List<CustomerOpinion> findCustomerOpinionsByProductId(Long product_id){
        String query = "SELECT * FROM opinions WHERE product_id = :product_id";
        try(Connection con = sql2o.open()){
            return con.createQuery(query)
                    .addParameter("product_id",product_id)
                    .executeAndFetch(CustomerOpinion.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico en caso de error
        }
    }

    @Override
    public List<CustomerOpinion> findCustomerOpinionsByClientId(Long client_id){
        String query = "SELECT * FROM opinions WHERE client_id = :client_id";
        try(Connection con = sql2o.open()){
            return con.createQuery(query)
                    .addParameter("client_id",client_id)
                    .executeAndFetch(CustomerOpinion.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico en caso de error
        }
    }

    @Override
    public void saveOpinion(CustomerOpinion opinion){
        String query = "INSERT INTO opinions (opinion_id, commentary, rating, product_id, client_id) " +
                "VALUES (:opinion_id, :commentary, :rating, :product_id, :client_id)";
        try(Connection con = sql2o.beginTransaction()){
            con.createQuery(query)
                    .addParameter("opinion_id", opinion.getOpinion_id())
                    .addParameter("commentary", opinion.getCommentary())
                    .addParameter("rating", opinion.getRating())
                    .addParameter("product_id", opinion.getProduct_id())
                    .addParameter("client_id", opinion.getClient_id())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOpinion(CustomerOpinion opinion){
        String query = "UPDATE opinions " +
                "SET commentary = :commentary, rating = :rating, product_id = :product_id, client_id = :client_id " +
                "WHERE opinion_id = :opinion_id";
        try(Connection con = sql2o.beginTransaction()){
            con.createQuery(query)
                    .addParameter("commentary", opinion.getCommentary())
                    .addParameter("rating", opinion.getRating())
                    .addParameter("product_id", opinion.getProduct_id())
                    .addParameter("client_id", opinion.getClient_id())
                    .addParameter("opinion_id", opinion.getOpinion_id())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOpinionById(Long opinion_id){
        String query = "DELETE FROM opinions WHERE opinion_id = :opinion_id";
        try (Connection con = sql2o.beginTransaction()){
            con.createQuery(query)
                    .addParameter("opinion_id",opinion_id)
                    .executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}