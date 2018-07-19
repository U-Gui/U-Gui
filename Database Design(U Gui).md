## Database Design(U Gui)

* User

| Name         | type          | constraint  | Instroduction   |
| ------------ | ------------- | ----------- | --------------- |
| userId       | int           | primary key |                 |
| userPhone    | varchar(11)   |             |                 |
| userSex      | bit           |             | 0-male 1-female |
| userBalance  | Decimal(20,2) |             | money           |
| userBoxtime  | Decimal(20,2) |             |                 |
| userMajorId  | int           | foreign key | Major(majorId)  |
| usersignDays | int           |             |                 |
| lastsignTime | Date          |             |                 |

* School

| Name       | type        | constraint  | Instroduction |
| ---------- | ----------- | ----------- | ------------- |
| schoolId   | int         | primary key |               |
| schoolName | varchar(30) |             |               |

* Major

| Name      | type        | constraint  | Instroduction    |
| --------- | ----------- | ----------- | ---------------- |
| majorId   | int         | primary key |                  |
| majorName | varchar(10) |             |                  |
| schoolId  | int         | foreign key | School(schoolId) |

* BoxLocation

| Name            | type        | constraint  | Instroduction    |
| --------------- | ----------- | ----------- | ---------------- |
| boxlocationId   | int         | primary key |                  |
| boxShoolId      | int         | foreign key | School(schoolId) |
| boxlocationName | varchar(50) |             |                  |

* BoxInfo

| Name          | type        | constraint  | Instroduction                                                |
| ------------- | ----------- | ----------- | ------------------------------------------------------------ |
| boxId         | int         | primary key |                                                              |
| boxlocationId | int         | foreign key | BoxLocation(boxlocationId)                                   |
| boxInfo       | varchar(20) |             | <b>I didn`t think about it for a while,but  just reserved it.</b> |
| boxStatus     | int         |             | 0-Idle 1-used 2-broken                                       |
| boxType       | int         |             | <b>I didn`t think about it for a while,but  just reserved it.</b> |

* BoxUseRecord

| Name       | type   | constraint  | instroduction  |
| ---------- | ------ | ----------- | -------------- |
| recordId   | int    | primary key |                |
| boxId      | int    | foreign key | BoxInfo(boxId) |
| userId     | int    | foreign key | User(userId)   |
| strat_time | Bigint |             |                |
| end_time   | Bigint |             |                |





