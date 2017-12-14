

# ![logo](Images/table.svg) mount

## <a name="#Description"></a>Description
> This table is used to set the times when the tire is mount. The relation with retread is because the mount is based in the retread, not in the tire.
## <a name="#Properties"></a>Properties
|Name|Value|
|---|---|
|Engine|InnoDB|
|Auto Increment|0|
|Average Row Length|0|
|Charset|utf8|
|Collation|utf8_general_ci|
|Row Format|Compact|
|Min Rows|0|
|Max Rows|0|
|Checksum|False|
|Page Checksum|True|
|Transactional|True|
|Pack Keys|False|
|Delay Key Write|False|
|Is Partitioned|False|
|Created|13/12/2017 20:32:56|
|Last Modified|01/01/0001 00:00:00|


## <a name="#Columns"></a>Columns
|Key|Name|Data Type|Length|Precision|Scale|Not Null|Auto Increment|Default|Virtual|Unsigned|Zerofill|Binary|Description
|---|---|---|---|---|---|---|---|---|---|---|---|---|---
|[![Primary Key PRIMARY](Images/primarykey.svg)](#Indexes)[![Indexes PRIMARY](Images/index.svg)](#Indexes)|id|INT||11||True|False||False|False|False|False|Internal identification of records for this table|
|[![Foreign Keys fk_mount_truck1: ](Images/foreignkey.svg)](#ForeignKeys)[![Indexes fk_mount_truck1_idx](Images/index.svg)](#Indexes)|truck_id|INT||11||True|False||False|False|False|False||
|[![Foreign Keys fk_mount_retread1: ](Images/foreignkey.svg)](#ForeignKeys)[![Indexes fk_mount_retread1_idx](Images/index.svg)](#Indexes)|retread_id|INT||11||True|False||False|False|False|False||
|[![Foreign Keys fk_mount_locationMount1: ](Images/foreignkey.svg)](#ForeignKeys)[![Indexes fk_mount_locationMount1_idx](Images/index.svg)](#Indexes)|mountLocation_id|INT||11||True|False||False|False|False|False||
||mountDate|DATETIME||||True|False||False|False|False|False|Date of tire mounting|
||mountKm|DOUBLE||||True|False||False|False|False|False|Truck mileage on the mount|

## <a name="#Indexes"></a>Indexes
|Key|Name|Columns|Unique|Type|Key Lengths
|---|---|---|---|---|---
||fk_mount_locationMount1_idx|mountLocation_id|False|BTREE||
||fk_mount_retread1_idx|retread_id|False|BTREE||
||fk_mount_truck1_idx|truck_id|False|BTREE||
|[![Primary Key PRIMARY](Images/primarykey.svg)](#Indexes)|PRIMARY|id|True|BTREE||

## <a name="#ForeignKeys"></a>Foreign Keys
|Name|Columns|Delete Rule|Update Rule
|---|---|---|---
|fk_mount_locationMount1|id|NO ACTION|NO ACTION|
|fk_mount_retread1|id|NO ACTION|NO ACTION|
|fk_mount_truck1|id|NO ACTION|NO ACTION|

## <a name="#SqlScript"></a>SQL Script
```SQL
CREATE TABLE mount (
  id INT(11) NOT NULL COMMENT 'Internal identification of records for this table',
  truck_id INT(11) NOT NULL,
  retread_id INT(11) NOT NULL,
  mountLocation_id INT(11) NOT NULL,
  mountDate DATETIME NOT NULL COMMENT 'Date of tire mounting',
  mountKm DOUBLE NOT NULL COMMENT 'Truck mileage on the mount',
  PRIMARY KEY (id),
  INDEX fk_mount_locationMount1_idx (mountLocation_id),
  INDEX fk_mount_retread1_idx (retread_id),
  INDEX fk_mount_truck1_idx (truck_id),
  CONSTRAINT fk_mount_locationMount1 FOREIGN KEY (mountLocation_id)
    REFERENCES mountlocation(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_mount_retread1 FOREIGN KEY (retread_id)
    REFERENCES retread(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_mount_truck1 FOREIGN KEY (truck_id)
    REFERENCES truck(id) ON DELETE NO ACTION ON UPDATE NO ACTION
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'This table is used to set the times when the tire is mount. The relation with retread is because the mount is based in the retread, not in the tire.'
ROW_FORMAT = COMPACT;
```

## <a name="#DependsOn"></a>Depends On _`3`_
- [mountlocation](mountlocation.md)
- [retread](retread.md)
- [truck](truck.md)


## <a name="#UsedBy"></a>Used By _`1`_
- [unmount](unmount.md)


___
###### Author: Leonardo Meneguzzi
###### Copyright © All Rights Reserved
###### Created: 13/12/2017
