package service.impl;

import dao.PersonDao;
import domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PersonService;

/**
 * Created by martsforever on 2016/1/22.
 */
@Service("PersonService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDao personDao;

    @Override
    public Person login(String account, String password) {
        return personDao.findPersonByAccountAndPassword(account, password);
    }

    @Override
    public Person getPerson(String account) {
        return personDao.findPersonByAccount(account);
    }

    @Override
    public void registerPerson(Person person) {
        personDao.addPerson(person);
    }

    @Override
    public boolean isUsernameExist(String name) {
        Boolean isExist = false;
        Person person = personDao.findPersonByAccount(name);
        if (person == null) isExist = false;
        else isExist = true;
        return isExist;
    }
}