package com.anseko.c1.service;

import com.anseko.c1.domain.Person;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Sergienko <andrey.sergienko@gmail.com>
 * Date: 9/19/12
 * Time: 11:39 AM
 */

@Service("personService")
@Transactional
public class PersonService
{
    protected static Logger logger = Logger.getLogger(PersonService.class);

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) { this. entityManager = entityManager; }

    public Person get(Integer id)
    {
        logger.debug("Retrieving person by id");
        Query query = entityManager.createQuery("FROM Person as p WHERE p.id="+id);
        return (Person) query.getSingleResult();
    }

    public Person get(String login)
    {
        logger.debug("Retrieving person by login");
        Query query = entityManager.createQuery("FROM Person as p WHERE p.login='"+login+"'");
        return (Person) query.getSingleResult();
    }

    public void add(Person person)
    {
        logger.debug("Adding new person");
        entityManager.persist(person);
    }
}
