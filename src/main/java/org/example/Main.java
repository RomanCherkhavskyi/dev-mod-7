package org.example;

public class Main {

        public static void main(String[] args)  {

            System.out.println(new HttpStatusChecker().getStatusImage(2030));
            System.out.println(new HttpStatusChecker().getStatusImage(401));
            System.out.println(new HttpStatusChecker().getStatusImage(200));

            new HttpStatusImageDownloader().downloadStatusImage(201);
            new HttpStatusImageDownloader().downloadStatusImage(403);
            new HttpStatusImageDownloader().downloadStatusImage(2010);


        }

}

