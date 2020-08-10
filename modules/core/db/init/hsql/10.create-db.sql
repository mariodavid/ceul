-- begin CEUL_IMPORT_ENTRY
create table CEUL_IMPORT_ENTRY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CUSTOMER_NAME varchar(255),
    --
    primary key (ID)
)^
-- end CEUL_IMPORT_ENTRY
