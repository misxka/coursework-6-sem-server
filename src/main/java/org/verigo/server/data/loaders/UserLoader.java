package org.verigo.server.data.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.User;
import org.verigo.server.data.repositories.UserRepository;

import java.text.SimpleDateFormat;

@Component
@Order(1)
public class UserLoader implements CommandLineRunner {
    private final UserRepository repository;

    @Autowired
    public UserLoader(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

            this.repository.save(new User("teacher", "password", "fakemail@mailmailmailmail.com", "Иванов Иван", "TEACHER", formatter.parse("01-02-2020")));
            this.repository.save(new User("student1", "password", "fakemail@mailmailmailmail1.com", "Петров Иван", "STUDENT", formatter.parse("01-02-2020")));
            this.repository.save(new User("student2", "password", "fakemail@mailmailmailmail2.com", "Сергеев Иван", "STUDENT", formatter.parse("01-02-2020")));
            this.repository.save(new User("admin", "admin", "fakemail@mailmailmailmail3.com", "Сидоров Иван", "ADMIN", formatter.parse("01-02-2020")));

            this.repository.save(new User("teacher1", "password", "fakemail@mailmailmailmail01.com", "Иванов Иван", "TEACHER", formatter.parse("02-03-2020")));
            this.repository.save(new User("student11", "password", "fakemail@mailmailmailmail11.com", "Петров Иван", "STUDENT", formatter.parse("03-03-2020")));
            this.repository.save(new User("student12", "password", "fakemail@mailmailmailmail12.com", "Сергеев Иван", "STUDENT", formatter.parse("06-03-2020")));
            this.repository.save(new User("admin1", "admin", "fakemail@mailmailmailmail13.com", "Сидоров Иван", "ADMIN", formatter.parse("07-05-2020")));

            this.repository.save(new User("teacher2", "password", "fakemail@mailmailmailmail02.com", "Иванов Иван", "TEACHER", formatter.parse("01-04-2020")));
            this.repository.save(new User("student21", "password", "fakemail@mailmailmailmail21.com", "Петров Иван", "STUDENT", formatter.parse("01-05-2020")));
            this.repository.save(new User("student22", "password", "fakemail@mailmailmailmail22.com", "Сергеев Иван", "STUDENT", formatter.parse("05-02-2020")));
            this.repository.save(new User("admin2", "admin", "fakemail@mailmailmailmail23.com", "Сидоров Иван", "ADMIN", formatter.parse("12-08-2020")));

            this.repository.save(new User("teacher3", "password", "fakemail@mailmailmailmail03.com", "Иванов Иван", "TEACHER", formatter.parse("23-02-2020")));
            this.repository.save(new User("student31", "password", "fakemail@mailmailmailmail31.com", "Петров Иван", "STUDENT", formatter.parse("23-01-2020")));
            this.repository.save(new User("student32", "password", "fakemail@mailmailmailmail32.com", "Сергеев Иван", "STUDENT", formatter.parse("26-02-2020")));
            this.repository.save(new User("admin3", "admin", "fakemail@mailmailmailmail33.com", "Сидоров Иван", "ADMIN", formatter.parse("07-07-2020")));

            this.repository.save(new User("teacher4", "password", "fakemail@mailmailmailmail4.com", "Иванов Иван", "TEACHER", formatter.parse("01-02-2021")));
            this.repository.save(new User("student41", "password", "fakemail@mailmailmailmail41.com", "Петров Иван", "STUDENT", formatter.parse("06-02-2021")));
            this.repository.save(new User("student42", "password", "fakemail@mailmailmailmail42.com", "Сергеев Иван", "STUDENT", formatter.parse("16-02-2021")));
            this.repository.save(new User("admin4", "admin", "fakemail@mailmailmailmail43.com", "Сидоров Иван", "ADMIN", formatter.parse("21-02-2021")));

            this.repository.save(new User("teacher5", "password", "fakemail@mailmailmailmail5.com", "Иванов Иван", "TEACHER", formatter.parse("14-10-2021")));
            this.repository.save(new User("student51", "password", "fakemail@mailmailmailmail51.com", "Петров Иван", "STUDENT", formatter.parse("12-03-2021")));
            this.repository.save(new User("student52", "password", "fakemail@mailmailmailmail52.com", "Сергеев Иван", "STUDENT", formatter.parse("01-09-2021")));
            this.repository.save(new User("admin5", "admin", "fakemail@mailmailmailmail53.com", "Сидоров Иван", "ADMIN", formatter.parse("11-12-2021")));

            this.repository.save(new User("teacher6", "password", "fakemail@mailmailmailmail6.com", "Иванов Иван", "TEACHER", formatter.parse("11-12-2021")));
            this.repository.save(new User("student61", "password", "fakemail@mailmailmailmail61.com", "Петров Иван", "STUDENT", formatter.parse("12-12-2021")));
            this.repository.save(new User("student62", "password", "fakemail@mailmailmailmail62.com", "Сергеев Иван", "STUDENT", formatter.parse("13-12-2021")));
            this.repository.save(new User("admin6", "admin", "fakemail@mailmailmailmail63.com", "Сидоров Иван", "ADMIN", formatter.parse("11-11-2021")));

            this.repository.save(new User("teacher7", "password", "fakemail@mailmailmailmail7.com", "Иванов Иван", "TEACHER", formatter.parse("01-11-2021")));
            this.repository.save(new User("student71", "password", "fakemail@mailmailmailmail71.com", "Петров Иван", "STUDENT", formatter.parse("07-11-2021")));
            this.repository.save(new User("student72", "password", "fakemail@mailmailmailmail72.com", "Сергеев Иван", "STUDENT", formatter.parse("11-06-2021")));
            this.repository.save(new User("admin7", "admin", "fakemail@mailmailmailmail73.com", "Сидоров Иван", "ADMIN", formatter.parse("06-01-2022")));

            this.repository.save(new User("teacher8", "password", "fakemail@mailmailmailmail8.com", "Иванов Иван", "TEACHER", formatter.parse("18-02-2022")));
            this.repository.save(new User("student81", "password", "fakemail@mailmailmailmail81.com", "Петров Иван", "STUDENT", formatter.parse("09-02-2022")));
            this.repository.save(new User("student82", "password", "fakemail@mailmailmailmail82.com", "Сергеев Иван", "STUDENT", formatter.parse("08-02-2022")));
            this.repository.save(new User("admin8", "admin", "fakemail@mailmailmailmail83.com", "Сидоров Иван", "ADMIN", formatter.parse("10-03-2022")));

            this.repository.save(new User("teacher9", "password", "fakemail@mailmailmailmail9.com", "Иванов Иван", "TEACHER", formatter.parse("19-03-2022")));
            this.repository.save(new User("student91", "password", "fakemail@mailmailmailmail91.com", "Петров Иван", "STUDENT", formatter.parse("15-03-2022")));
            this.repository.save(new User("student92", "password", "fakemail@mailmailmailmail92.com", "Сергеев Иван", "STUDENT", formatter.parse("09-03-2022")));
            this.repository.save(new User("admin9", "admin", "fakemail@mailmailmailmail93.com", "Сидоров Иван", "ADMIN", formatter.parse("12-04-2022")));
        }
    }
}
