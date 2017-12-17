### To see the complete documentation [click here](MDDocDB/readme.md)

## Schema documentation

___
## Table: `tire`

### Description: `This table represent the tire's carcass.`

### Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   | Internal identification of records for this table |
| `tireBrand_id` | INT | Not null |   |  **foreign key** to column `id` on table `tireBrand`. |
| `tireModel_id` | INT | Not null |   |  **foreign key** to column `id` on table `tireModel`. |
| `tireSituation_id` | INT | Not null |   |  **foreign key** to column `id` on table `tireSituation`. |
| `physicalIdentification` | INT | Not null |   | External identification of records for this table. The user sets this value |
| `expectedNumberRetreads` | INT | Not null |   | Expected number of retreads tire |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |
| fk_tire_brand_idx | `tireBrand_id` | INDEX |   |
| fk_tire_model1_idx | `tireModel_id` | INDEX |   |
| fk_tire_tireSituation1_idx | `tireSituation_id` | INDEX |   |
___

## Table: `tireBrand`

### Description: `This table store tires brands.`

### Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   | Internal identification of records for this table |
| `name` | VARCHAR(200) | Not null |   | Tire Brand name |
| `suggestionNumberRetreads` |  |  |   | Suggestion of the number of retreads tire |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |
___

## Table: `tireModel`

### Description: `This table store tires models.`

### Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   | Internal identification of records for this table |
| `name` | VARCHAR(200) | Not null |   | Tire model name |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |
___

## Table: `tireSituation`

### Description: `This table is designed to set a current tire's situation. Ex: mounted, unmounted, died, unavailable, etc.`

### Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   | Internal identification of records for this table |
| `name` | VARCHAR(200) | Not null |   | Tire situation name |
| `description` | VARCHAR(1000) | Not null |   | Description of tire situation |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |
___

## Table: `retread`

### Description: `This table store the retreads made on the tire.`

### Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   | Internal identification of records for this table |
| `tire_id` | INT | Not null |   |  **foreign key** to column `id` on table `tire`. |
| `bandType_id` | INT | Not null |   |  **foreign key** to column `id` on table `bandType`. |
| `number` | INT | Not null |   | Current retread tire number. For the new tire, retread number is zero |
| `date` | DATETIME | Not null |   | Tire purchase/retread date |
| `value` | DOUBLE | Not null |   | Value purchase/retread date |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |
| fk_retread_bandType1_idx | `bandType_id` | INDEX |   |
| fk_retread_tire1_idx | `tire_id` | INDEX |   |
___

## Table: `bandType`

### Description: `This table store tires band types.`

## Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   | Internal identification of records for this table |
| `name` | VARCHAR(200) | Not null |   | Band type name |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |
___

## Table: `mount`

### Description: `This table is used to set the times when the tire is mount. The relation with retread is because the mount is based in the retread, not in the tire.`

### Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   | Internal identification of records for this table |
| `truck_id` | INT | Not null |   |  **foreign key** to column `id` on table `truck`. |
| `retread_id` | INT | Not null |   |  **foreign key** to column `id` on table `retread`. |
| `mountLocation_id` | INT | Not null |   |  **foreign key** to column `id` on table `mountLocation`. |
| `date` | DATETIME | Not null |   | Date of tire mounting |
| `km` | DOUBLE | Not null |   | Truck mileage on the mount |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |
| fk_mount_locationMount1_idx | `mountLocation_id` | INDEX |   |
| fk_mount_retread1_idx | `retread_id` | INDEX |   |
| fk_mount_truck1_idx | `truck_id` | INDEX |   |
___

## Table: `mountLocation`

### Description: `Physical location of the tire on the truck where it was mounted.`

### Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   | Internal identification of records for this table |
| `name` | VARCHAR(200) | Not null |   | Mount location tire in the truck |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |
___

## Table: `unmountReason`

### Description: `The unmount have a reason. Ex: mechanical problems, end of life, factory problem, etc.`

### Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   |   |
| `name` | VARCHAR(200) | Not null |   | Reason for unmount the tire |
| `description` | VARCHAR(1000) | Not null |   | Reason description |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |
___

## Table: `truck`

### Description: `Used to identify the truck that the tire will be mounted.`

### Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   | Internal identification of records for this table |
| `plate` | VARCHAR(50) | Not null |   | Plate truck |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |
___

## Table: `unmount`

### Description: `This table is used to store an unmount.`

### Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   | Internal identification of records for this table |
| `mount_id` | INT | Not null |   |  **foreign key** to column `id` on table `mount`. |
| `unmountReason_id` | INT | Not null |   |  **foreign key** to column `id` on table `unmountReason`. |
| `date` | DATETIME | Not null |   | Date of tire unmounting |
| `km` | DOUBLE | Not null |   | Truck mileage on the unmount |
| `note` | VARCHAR(1000) |  |   |   |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |
| fk_mount_unmountReason1_idx | `unmountReason_id` | INDEX |   |
| fk_unmount_mount1_idx | `mount_id` | INDEX |   |
| mount_id_UNIQUE | `mount_id` | UNIQUE |   |