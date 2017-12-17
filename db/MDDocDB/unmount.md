

# ![logo](Images/table.svg) unmount

## <a name="#Description"></a>Description
> This table is used to store an unmount.
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
|[![Primary Key PRIMARY](Images/primarykey.svg)](#Indexes)[![Indexes PRIMARY](Images/index.svg)](#Indexes)|id|INT||11||True|True||False|False|False|False|Internal identification of records for this table|
|[![Foreign Keys fk_unmount_mount1: ](Images/foreignkey.svg)](#ForeignKeys)[![Indexes fk_unmount_mount1_idx](Images/index.svg)](#Indexes)|mount_id|INT||11||True|False||False|False|False|False||
|[![Foreign Keys fk_mount_unmountReason10: ](Images/foreignkey.svg)](#ForeignKeys)[![Indexes fk_mount_unmountReason1_idx](Images/index.svg)](#Indexes)|unmountReason_id|INT||11||True|False||False|False|False|False||
||date|DATETIME||||True|False||False|False|False|False|Date of tire unmounting|
||km|DOUBLE||||True|False||False|False|False|False|Truck mileage on the unmount|
||note|VARCHAR|1000|||False|False|NULL|False|False|False|False||

## <a name="#Indexes"></a>Indexes
|Key|Name|Columns|Unique|Type|Key Lengths
|---|---|---|---|---|---
||fk_mount_unmountReason1_idx|unmountReason_id|False|BTREE||
||fk_unmount_mount1_idx|mount_id|False|BTREE||
||mount_id_unique|mount_id|True|BTREE||
|[![Primary Key PRIMARY](Images/primarykey.svg)](#Indexes)|PRIMARY|id|True|BTREE||

## <a name="#ForeignKeys"></a>Foreign Keys
|Name|Columns|Delete Rule|Update Rule
|---|---|---|---
|fk_mount_unmountReason10|id|NO ACTION|NO ACTION|
|fk_unmount_mount1|id|NO ACTION|NO ACTION|

## <a name="#SqlScript"></a>SQL Script
```SQL
CREATE TABLE unmount (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Internal identification of records for this table',
  mount_id INT(11) NOT NULL,
  unmountReason_id INT(11) NOT NULL,
  date DATETIME NOT NULL COMMENT 'Date of tire unmounting',
  km DOUBLE NOT NULL COMMENT 'Truck mileage on the unmount',
  note VARCHAR(1000) DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX fk_mount_unmountReason1_idx (unmountReason_id),
  INDEX fk_unmount_mount1_idx (mount_id),
  UNIQUE INDEX mount_id_UNIQUE (mount_id),
  CONSTRAINT fk_mount_unmountReason10 FOREIGN KEY (unmountReason_id)
    REFERENCES unmountreason(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_unmount_mount1 FOREIGN KEY (mount_id)
    REFERENCES mount(id) ON DELETE NO ACTION ON UPDATE NO ACTION
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'This table is used to store an unmount.'
ROW_FORMAT = COMPACT;
```

## <a name="#DependsOn"></a>Depends On _`2`_
- [mount](mount.md)
- [unmountreason](unmountreason.md)


## <a name="#UsedBy"></a>Used By


___
###### Author: Leonardo Meneguzzi
###### Copyright © All Rights Reserved
###### Created: 13/12/2017
