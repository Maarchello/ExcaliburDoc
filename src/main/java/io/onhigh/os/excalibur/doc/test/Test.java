package io.onhigh.os.excalibur.doc.test;

import io.onhigh.os.excalibur.doc.ExDoc;
import io.onhigh.os.excalibur.doc.ExDocWriter;
import io.onhigh.os.excalibur.doc.xlsx.schema.ExWorkbook;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public class Test {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
//            user.setAge(i+1);
//            user.setId(i);
            user.setName("Name of user " + i);
            user.setLastName("Last name of user " + i);

            users.add(user);
        }

        ExDocWriter exDocWriter = ExDoc.builderXlsx()
                .sheet("Sheet of Users", users)
                .build();

        ExWorkbook exWorkbook = exDocWriter.write();
        exWorkbook.saveToDisk(Paths.get("C:\\Marchello\\Projects\\Excalibur\\frmw.xlsx"));
        System.out.println(exWorkbook);

    }

}
