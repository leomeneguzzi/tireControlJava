

# ![logo](../../../../../Images/table.svg) truck

## <a name="#Description"></a>Description
> Used to identify the truck that the tire will be mounted.
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
|[![Primary Key PRIMARY](../../../../../Images/primarykey.svg)](#Indexes)[![Indexes PRIMARY](../../../../../Images/index.svg)](#Indexes)|id|INT||11||True|True||False|False|False|False|Internal identification of records for this table|
||plate|VARCHAR|50|||True|False||False|False|False|False|Plate truck|

## <a name="#Indexes"></a>Indexes
|Key|Name|Columns|Unique|Type|Key Lengths
|---|---|---|---|---|---
|[![Primary Key PRIMARY](../../../../../Images/primarykey.svg)](#Indexes)|PRIMARY|id|True|BTREE||

## <a name="#SqlScript"></a>SQL Script
```SQL
CREATE TABLE truck (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Internal identification of records for this table',
  plate VARCHAR(50) NOT NULL COMMENT 'Plate truck',
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'Used to identify the truck that the tire will be mounted.'
ROW_FORMAT = COMPACT;
```

## <a name="#DependsOn"></a>Depends On


## <a name="#UsedBy"></a>Used By _`1`_
- [mount](mount.md)


___
###### Author: Leonardo Meneguzzi
###### Copyright © All Rights Reserved
###### Created: 13/12/2017
