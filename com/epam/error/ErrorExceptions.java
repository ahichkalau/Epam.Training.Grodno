package com.epam.error;

/*В символьном файле находится информация об N числах с плавающей запятой. Прочитать информацию из файла.
Проверить на корректность, то есть являются ли данные числами. Преобразовать к числовым значениям и вычислить
сумму и среднее значение прочитанных чисел.

Создать собственный класс исключения.

Предусмотреть обработку исключений, возникающих при нехватке памяти, отсутствии самого файла по заданному адресу,
отсутствии или некорректности требуемой записи в файле, недопустимом значении поля (выходящим за пределы максимально
допустимых значений) и т. д.*/

import java.io.FileNotFoundException;
import java.io.IOException;

//public class ErrorExceptions {
//    public static void main(String[] args) {
//        FileWithFloatingPoint fileWithFloatingPoint = new FileWithFloatingPoint();
//        try {
//            fileWithFloatingPoint.readFile("src/resources/FloatingDouble.txt");
//        }
//        catch (ExceptionsForFileFloatingPoint e){
//            System.out.println(e);
//        }
//    }
//}
