

# ![logo](Images/table.svg) tire

## <a name="#Description"></a>Description
> This table represent the tire's carcass.
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
|[![Foreign Keys fk_tire_brand: ](Images/foreignkey.svg)](#ForeignKeys)[![Indexes fk_tire_brand_idx](Images/index.svg)](#Indexes)|tireBrand_id|INT||11||True|False||False|False|False|False||
|[![Foreign Keys fk_tire_model1: ](Images/foreignkey.svg)](#ForeignKeys)[![Indexes fk_tire_model1_idx](Images/index.svg)](#Indexes)|tireModel_id|INT||11||True|False||False|False|False|False||
|[![Foreign Keys fk_tire_tireSituation1: ](Images/foreignkey.svg)](#ForeignKeys)[![Indexes fk_tire_tireSituation1_idx](Images/index.svg)](#Indexes)|tireSituation_id|INT||11||True|False||False|False|False|False||
||physicalIdentification|INT||11||True|False||False|False|False|False|External identification of records for this table. The user sets this value|
||expectedNumberRetreads|INT||11||True|False||False|False|False|False|Expected number of retreads tire|

## <a name="#Indexes"></a>Indexes
|Key|Name|Columns|Unique|Type|Key Lengths
|---|---|---|---|---|---
||fk_tire_brand_idx|tireBrand_id|False|BTREE||
||fk_tire_model1_idx|tireModel_id|False|BTREE||
||fk_tire_tireSituation1_idx|tireSituation_id|False|BTREE||
|[![Primary Key PRIMARY](Images/primarykey.svg)](#Indexes)|PRIMARY|id|True|BTREE||

## <a name="#ForeignKeys"></a>Foreign Keys
|Name|Columns|Delete Rule|Update Rule
|---|---|---|---
|fk_tire_brand|id|NO ACTION|NO ACTION|
|fk_tire_model1|id|NO ACTION|NO ACTION|
|fk_tire_tireSituation1|id|NO ACTION|NO ACTION|

## <a name="#SqlScript"></a>SQL Script
```SQL
CREATE TABLE tire (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Internal identification of records for this table',
  tireBrand_id INT(11) NOT NULL,
  tireModel_id INT(11) NOT NULL,
  tireSituation_id INT(11) NOT NULL,
  physicalIdentification INT(11) NOT NULL COMMENT 'External identification of records for this table. The user sets this value',
  expectedNumberRetreads INT(11) NOT NULL COMMENT 'Expected number of retreads tire',
  PRIMARY KEY (id),
  INDEX fk_tire_brand_idx (tireBrand_id),
  INDEX fk_tire_model1_idx (tireModel_id),
  INDEX fk_tire_tireSituation1_idx (tireSituation_id),
  CONSTRAINT fk_tire_brand FOREIGN KEY (tireBrand_id)
    REFERENCES tirebrand(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_tire_model1 FOREIGN KEY (tireModel_id)
    REFERENCES tiremodel(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_tire_tireSituation1 FOREIGN KEY (tireSituation_id)
    REFERENCES tiresituation(id) ON DELETE NO ACTION ON UPDATE NO ACTION
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = 'This table represent the tire''s carcass.'
ROW_FORMAT = COMPACT;
```

## <a name="#DependsOn"></a>Depends On _`3`_
- [tirebrand](tirebrand.md)
- [tiremodel](tiremodel.md)
- [tiresituation](tiresituation.md)


## <a name="#UsedBy"></a>Used By _`1`_
- [retread](retread.md)


___
###### Author: Leonardo Meneguzzi
###### Copyright © All Rights Reserved
###### Created: 13/12/2017
