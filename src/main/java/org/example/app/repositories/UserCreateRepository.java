package org.example.app.repositories;

import org.example.app.entities.User;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserCreateRepository {

    public String createUser(User user) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "INSERT INTO User (username, firstName, lastName, birthDate, email, phone) " +
                    "VALUES (:username, :firstName, :lastName, :birthDate, :email, :phone)";

            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("username", user.getUsername());
            query.setParameter("firstName", user.getFirstName());
            query.setParameter("lastName", user.getLastName());
            query.setParameter("birthDate", user.getBirthDate());
            query.setParameter("email", user.getEmail());
            query.setParameter("phone", user.getPhone());
            query.executeUpdate();

            transaction.commit();
            return Constants.DATA_INSERT_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}
