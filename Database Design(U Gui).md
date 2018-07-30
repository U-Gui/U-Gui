## Database Design(U Gui)

* User

| Name         | type          | constraint  | Instroduction   |
| ------------ | ------------- | ----------- | --------------- |
| userId       | varchar(20)   | primary key | openId          |
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

| Name      | type | constraint  | Instroduction          |
| --------- | ---- | ----------- | ---------------------- |
| boxId     | int  | primary key |                        |
| boxStatus | int  |             | 0-Idle 1-used 2-broken |
| boxType   | int  |             | 0-small 1-middle 2-big |
| cabinetId | int  | foreign key | Cabinet(cabinetId)     |

* Cabinet

| Name          | type | constraint  | Instroduction              |
| ------------- | ---- | ----------- | -------------------------- |
| cabinetId     | int  | primary key |                            |
| boxLocationId | int  | Foreign key | BoxLocation(boxLocationId) |

* BoxUseRecord

| Name       | type   | constraint  | instroduction  |
| ---------- | ------ | ----------- | -------------- |
| recordId   | int    | primary key |                |
| boxId      | int    | foreign key | BoxInfo(boxId) |
| userId     | int    | foreign key | User(userId)   |
| strat_time | Bigint |             |                |
| end_time   | Bigint |             |                |





