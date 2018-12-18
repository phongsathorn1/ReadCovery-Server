# 📖🖥 ReadCovery-Server
ReadCovery Server เป็นเซิฟเวอร์ที่ให้บริการ REST API สำหรับโปรแกรม ReadCovery มีหน้าที่จัดการระบบยืนยันตัวตนและการติดต่อกับระบบฐานข้อมูล MySQL Server

### ไฟล์ [.jar](https://github.com/oop-it-kmitl-61/ReadCovery-Server/releases/download/1.0/ReadcoveryServer-1.0-SNAPSHOT.jar) อยู่ใน release

*สำหรับ ReadCovery Client [คลิก](https://github.com/oop-it-kmitl-61/ReadCovery)*

## Requirements
- Java 1.8
- Maven
- MySQL or MariaDB

## Library ที่ใช้
- [Spring Boot](http://spring.io) เป็น Framework สำหรับการทำ Web service

## วิธีการ Complie
- ทำการ Clone git
  ```
    git clone https://github.com/Phongsathron/ReadCovery-Server.git
  ```
- แก้ไขการตั้งค่า MySQL ที่ไฟล์ `src/main/resources/application.properties`
  ```
    spring.datasource.url = jdbc:mysql://<ip or localhost>:3306/<readcovery or database name>?useSSL=false
    spring.datasource.username = <root or username>
    spring.datasource.password = <password>
  ```
- Complie ด้วยคำสั่ง
  ```
    mvn package
  ```
## การเตรียมฐานข้อมูล
- ดาวน์โหลด[ไฟล์](https://github.com/oop-it-kmitl-61/ReadCovery-Server/releases/download/1.0/ReadCovery.sql)
- ใช้คำสั่ง
  ```
    mysql -u <root or username> <readcovery or database name> < ReadCovery.sql
  ```

## การใช้งาน
- ใช้คำสั่ง
  ```
    java -jar ReadcoveryServer.jar
  ```

## 👨‍👨‍👦 Team Members
|  | ชื่อ | นามสกุล | GitHub Username | รหัสนักศึกษา |
|--|--|--|--|--|
| ![Fluk](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/Fluke.png) | นายพงศธร| กิตติวรปัญญา | [@Phongsathron](https://github.com/Phongsathron) | 60070055 |
| ![Net](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/Net.png) | นายพิชญพล| เพชรบุญช่วย | [@TheNlesh](https://github.com/TheNlesh) | 60070062 |
| ![Gunn](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/Gunn.png) | นายพุฒิเมธ | ธรรมแสง | [@jusmistic](https://github.com/jusmistic) | 60070068|


## 👩‍🏫 Assistant Teachers
| ผศ.ดร. ธนิศา นุ่มนนท์  |
| ------ |
| ![Professor](https://github.com/Phongsathron/ReadCovery/blob/GUI/src/img/Professor.png)

รายงานนี้เป็นส่วนหนึ่งของวิชา OBJECT-ORIENTED PROGRAMMING (06016317)

คณะเทคโนโลยีสารสนเทศ สถาบันเทคโนโลยีพระจอมเกล้าเจ้าคุณทหารลาดกระบัง
***

Faculty of Information Technology
King Mongkut's Institute of Technology Ladkrabang

***
