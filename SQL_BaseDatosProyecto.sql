drop table MNP_TABLERO cascade constraints;
drop table MNP_JUGADOR cascade constraints;
drop table MNP_PROPIEDAD cascade constraints;
create table MNP_TABLERO
(
  tab_id           NUMBER not null,
  tab_jugador1debe VARCHAR2(1) default 'N' not null,
  tab_jugador2debe VARCHAR2(1) default 'N' not null,
  tab_turno        VARCHAR2(2) default 'P1'
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column MNP_TABLERO.tab_id
  is 'Id de cada tablero o juego creado';
comment on column MNP_TABLERO.tab_jugador1debe
  is 'Jugador 1 tiene alguna deuda o no(S: si N: no)';
comment on column MNP_TABLERO.tab_jugador2debe
  is 'Jugador 2 tiene alguna deuda o no(S: si N: no)';
comment on column MNP_TABLERO.tab_turno
  is 'Cual jugador tiene el turno actual';
alter table MNP_TABLERO
  add constraint MNP_TABLERO_PK primary key (TAB_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MNP_TABLERO
  add constraint MNP_TABLERO_CK01
  check (tab_jugador1Debe in ('S','N'));
alter table MNP_TABLERO
  add constraint MNP_TABLERO_CK02
  check (tab_jugador2Debe in ('S','N'));
alter table MNP_TABLERO
  add constraint MNP_TABLERO_CK03
  check (tab_turno in ('P1','P2'));

create table MNP_JUGADOR
(
  jug_id        NUMBER not null,
  jug_nombre    VARCHAR2(50) not null,
  jug_saldo     NUMBER not null,
  jug_ficha     VARCHAR2(150) not null,
  jug_posicionx NUMBER not null,
  jug_posiciony NUMBER not null,
  tab_id        NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column MNP_JUGADOR.jug_id
  is 'Id de cada Jugador';
comment on column MNP_JUGADOR.jug_nombre
  is 'Nombre del jugador';
comment on column MNP_JUGADOR.jug_saldo
  is 'Dinero del jugador';
comment on column MNP_JUGADOR.jug_ficha
  is 'ficha del jugador';
comment on column MNP_JUGADOR.jug_posicionx
  is 'Posicion X del jugador';
comment on column MNP_JUGADOR.jug_posiciony
  is 'Posicion Y del jugador';
create index MNP_JUGADOR_UNQ01 on MNP_JUGADOR (TAB_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MNP_JUGADOR
  add constraint MNP_JUGADOR_PK primary key (JUG_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MNP_JUGADOR
  add constraint MNP_TABJUG_FK01 foreign key (TAB_ID)
  references MNP_TABLERO (TAB_ID);

create table MNP_PROPIEDAD
(
  pro_id         NUMBER not null,
  pro_nombre     VARCHAR2(60) not null,
  pro_hipotecada VARCHAR2(1) default 'N' not null,
  pro_casas      NUMBER,
  pro_hotel      NUMBER,
  jug_id         NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column MNP_PROPIEDAD.pro_id
  is 'Id de la propiedad';
comment on column MNP_PROPIEDAD.pro_nombre
  is 'Nombre de la propiedad';
comment on column MNP_PROPIEDAD.pro_hipotecada
  is 'Si la propiedad de encuentra hipotecada(S: si N: no)';
comment on column MNP_PROPIEDAD.pro_casas
  is 'Casas que posee la propiedad';
comment on column MNP_PROPIEDAD.pro_hotel
  is 'Si  la propiedad posee hotel';
create index MNP_PROPIEDAD_UNQ01 on MNP_PROPIEDAD (JUG_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MNP_PROPIEDAD
  add constraint PK_MNP_PROPIEDAD primary key (PRO_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MNP_PROPIEDAD
  add constraint MNP_JUGPROP_FK01 foreign key (JUG_ID)
  references MNP_JUGADOR (JUG_ID);
alter table MNP_PROPIEDAD
  add constraint MNP_PROPIEDAD_CK01
  check (pro_hipotecada in ('S','N'));

alter table MNP_JUGADOR disable constraint MNP_TABJUG_FK01;
alter table MNP_PROPIEDAD disable constraint MNP_JUGPROP_FK01;
insert into MNP_TABLERO (tab_id, tab_jugador1debe, tab_jugador2debe, tab_turno)
values (8, 'N', 'N', 'P1');
insert into MNP_JUGADOR (jug_id, jug_nombre, jug_saldo, jug_ficha, jug_posicionx, jug_posiciony, tab_id)
values (62, 'Anthony', 2023, 'Battleship.png', 6, 8, 8);
insert into MNP_JUGADOR (jug_id, jug_nombre, jug_saldo, jug_ficha, jug_posicionx, jug_posiciony, tab_id)
values (63, 'Harold', 2502, 'Car.png', 0, 2, 8);
insert into MNP_PROPIEDAD (pro_id, pro_nombre, pro_hipotecada, pro_casas, pro_hotel, jug_id)
values (47, 'Tren 1', 'N', 0, 0, 63);
insert into MNP_PROPIEDAD (pro_id, pro_nombre, pro_hipotecada, pro_casas, pro_hotel, jug_id)
values (48, 'Agua', 'N', 0, 0, 62);
insert into MNP_PROPIEDAD (pro_id, pro_nombre, pro_hipotecada, pro_casas, pro_hotel, jug_id)
values (28, 'Avenida Camaano', 'S', 0, 0, 63);
insert into MNP_PROPIEDAD (pro_id, pro_nombre, pro_hipotecada, pro_casas, pro_hotel, jug_id)
values (26, 'Avenida Lopez', 'S', 0, 0, 62);
insert into MNP_PROPIEDAD (pro_id, pro_nombre, pro_hipotecada, pro_casas, pro_hotel, jug_id)
values (27, 'Avenida Toros', 'N', 0, 0, 62);
insert into MNP_PROPIEDAD (pro_id, pro_nombre, pro_hipotecada, pro_casas, pro_hotel, jug_id)
values (29, 'Mirador', 'S', 0, 0, 63);
insert into MNP_PROPIEDAD (pro_id, pro_nombre, pro_hipotecada, pro_casas, pro_hotel, jug_id)
values (40, 'Calle Soledad', 'N', 0, 0, 63);
insert into MNP_PROPIEDAD (pro_id, pro_nombre, pro_hipotecada, pro_casas, pro_hotel, jug_id)
values (41, 'Avenida Central', 'N', 0, 0, 62);
insert into MNP_PROPIEDAD (pro_id, pro_nombre, pro_hipotecada, pro_casas, pro_hotel, jug_id)
values (42, 'Avenida Perez', 'N', 0, 0, 62);
insert into MNP_PROPIEDAD (pro_id, pro_nombre, pro_hipotecada, pro_casas, pro_hotel, jug_id)
values (39, 'Zona Franca', 'N', 0, 0, 62);
alter table MNP_JUGADOR enable constraint MNP_TABJUG_FK01;
alter table MNP_PROPIEDAD enable constraint MNP_JUGPROP_FK01;