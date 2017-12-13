

# ![logo](../../../../../Images/table.svg) bandtype

## <a name="#Description"></a>Description
> This table store tires band types.
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
||name|VARCHAR|200|||True|False||False|False|False|False|Band type name|

## <a name="#Indexes"></a>Indexes
|Key|Name|Columns|Unique|Type|Key Lengths
|---|---|---|---|---|---
|[![Primary Key PRIMARY](../../../../../Images/primarykey.svg)](#Indexes)|PRIMARY|id|True|BTREE||

## <a name="#SqlScript"></a>SQL Script
```SQL
CREATE TABLE bandtype (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Internal identification of records for this table',
  name VARCHAR(200) NOT NULL COMMENT 'Band type name',
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'This table store tires band types.'
ROW_FORMAT = COMPACT;
```

## <a name="#DependsOn"></a>Depends On


## <a name="#UsedBy"></a>Used By _`1`_
- [retread](retread.md)


___
###### Author: Leonardo Meneguzzi
###### Copyright © All Rights Reserved
###### Created: 13/12/2017
