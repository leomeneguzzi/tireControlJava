

# ![logo](Images/table.svg) retread

## <a name="#Description"></a>Description
> This table store the retreads made on the tire.
## <a name="#Properties"></a>Properties
|Name|Value|
|---|---|
|Engine|InnoDB|
|Auto Increment|1|
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
|[![Foreign Keys fk_retread_tire1: ](Images/foreignkey.svg)](#ForeignKeys)[![Indexes fk_retread_tire1_idx](Images/index.svg)](#Indexes)|tire_id|INT||11||True|False||False|False|False|False||
|[![Foreign Keys fk_retread_bandType1: ](Images/foreignkey.svg)](#ForeignKeys)[![Indexes fk_retread_bandType1_idx](Images/index.svg)](#Indexes)|bandType_id|INT||11||True|False||False|False|False|False||
||number|INT||11||True|False||False|False|False|False|Current retread tire number. For the new tire, retread number is zero|
||date|DATETIME||||True|False||False|False|False|False|Tire purchase/retread date|
||value|DOUBLE||||True|False||False|False|False|False|Value purchase/retread date|

## <a name="#Indexes"></a>Indexes
|Key|Name|Columns|Unique|Type|Key Lengths
|---|---|---|---|---|---
||fk_retread_bandType1_idx|bandType_id|False|BTREE||
||fk_retread_tire1_idx|tire_id|False|BTREE||
|[![Primary Key PRIMARY](Images/primarykey.svg)](#Indexes)|PRIMARY|id|True|BTREE||

## <a name="#ForeignKeys"></a>Foreign Keys
|Name|Columns|Delete Rule|Update Rule
|---|---|---|---
|fk_retread_bandType1|id|NO ACTION|NO ACTION|
|fk_retread_tire1|id|NO ACTION|NO ACTION|

## <a name="#SqlScript"></a>SQL Script
```SQL
CREATE TABLE retread (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Internal identification of records for this table',
  tire_id INT(11) NOT NULL,
  bandType_id INT(11) NOT NULL,
  number INT(11) NOT NULL COMMENT 'Current retread tire number. For the new tire, retread number is zero',
  date DATETIME NOT NULL COMMENT 'Tire purchase/retread date',
  value DOUBLE NOT NULL COMMENT 'Value purchase/retread date',
  PRIMARY KEY (id),
  INDEX fk_retread_bandType1_idx (bandType_id),
  INDEX fk_retread_tire1_idx (tire_id),
  CONSTRAINT fk_retread_bandType1 FOREIGN KEY (bandType_id)
    REFERENCES bandtype(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_retread_tire1 FOREIGN KEY (tire_id)
    REFERENCES tire(id) ON DELETE NO ACTION ON UPDATE NO ACTION
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'This table store the retreads made on the tire.'
ROW_FORMAT = COMPACT;
```

## <a name="#DependsOn"></a>Depends On _`2`_
- [bandtype](bandtype.md)
- [tire](tire.md)


## <a name="#UsedBy"></a>Used By _`1`_
- [mount](mount.md)


___
###### Author: Leonardo Meneguzzi
###### Copyright © All Rights Reserved
###### Created: 13/12/2017
