/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     29/7/2016 14:42:09                           */
/*==============================================================*/


drop table ALUMNO;

drop table ASISTENCIA;

drop table DOCENTE;

drop table MATERIA;

/*==============================================================*/
/* Table: ALUMNO                                                */
/*==============================================================*/
create table ALUMNO (
   ID_ALUMNO            SERIAL               not null,
   IDMATERIA            INT4                 null,
   NOMBRE               VARCHAR(30)          null,
   APELLIDO             VARCHAR(30)          null,
   EMAIL                VARCHAR(30)          null,
   DIRECCION            VARCHAR(30)          null,
   TELEFONO             VARCHAR(10)          null,
   CEDULA               VARCHAR(10)          null,
   constraint PK_ALUMNO primary key (ID_ALUMNO),
   constraint AK_KEY_1_ALUMNO unique (ID_ALUMNO)
);

/*==============================================================*/
/* Table: ASISTENCIA                                            */
/*==============================================================*/
create table ASISTENCIA (
   IDASISTENCIA         SERIAL               not null,
   ID_ALUMNO            INT4                 null,
   ASISTENCIA           BOOL                 null,
   FECHA                DATE                 null,
   constraint PK_ASISTENCIA primary key (IDASISTENCIA)
);

/*==============================================================*/
/* Table: DOCENTE                                               */
/*==============================================================*/
create table DOCENTE (
   IDDOCENTE            SERIAL               not null,
   NOMBRE               VARCHAR(30)          null,
   APELLIDO             VARCHAR(30)          null,
   USUARIO              VARCHAR(30)          null,
   CONTRASENA           VARCHAR(30)          null,
   constraint PK_DOCENTE primary key (IDDOCENTE)
);

/*==============================================================*/
/* Table: MATERIA                                               */
/*==============================================================*/
create table MATERIA (
   IDMATERIA            SERIAL               not null,
   IDDOCENTE            INT4                 null,
   MATERIA              VARCHAR(30)          null,
   TOTALASISTENCIA      INT4                 null,
   constraint PK_MATERIA primary key (IDMATERIA)
);

alter table ALUMNO
   add constraint FK_ALUMNO_REFERENCE_MATERIA foreign key (IDMATERIA)
      references MATERIA (IDMATERIA)
      on delete restrict on update restrict;

alter table ASISTENCIA
   add constraint FK_ASISTENC_REFERENCE_ALUMNO foreign key (ID_ALUMNO)
      references ALUMNO (ID_ALUMNO)
      on delete restrict on update restrict;

alter table MATERIA
   add constraint FK_MATERIA_REFERENCE_DOCENTE foreign key (IDDOCENTE)
      references DOCENTE (IDDOCENTE)
      on delete restrict on update restrict;

