
    create table AlimentoUnitario (
        DTYPE varchar(31) not null,
        id bigint not null auto_increment,
        uuid varchar(36) not null,
        nome varchar(100) not null,
        porcao float not null,
        unidadeGranel varchar(3) not null,
        categoriaAlimento_id bigint,
        primary key (id)
    );

    create table ApresentacaoMedidaAlimento (
        id bigint not null auto_increment,
        uuid varchar(36) not null,
        quantidade float not null,
        alimentoGranel_id bigint not null,
        tipoApresentacao_id bigint not null,
        tipoMedida_id bigint not null,
        primary key (id)
    );

    create table Cardapio (
        id bigint not null auto_increment,
        uuid varchar(36) not null,
        dia datetime not null,
        consulta_id bigint not null,
        divisaoRefeicao_id bigint not null,
        primary key (id)
    );

    create table CategoriaAlimento (
        id bigint not null auto_increment,
        caloriasPorPorcao float,
        uuid varchar(36) not null,
        nome varchar(100) not null,
        primary key (id)
    );

    create table CircunferenciaCorporal (
        id bigint not null auto_increment,
        tipoCircunferencia varchar(20) not null,
        valor float not null,
        primary key (id)
    );

    create table ClassificacaoIMC (
        id bigint not null auto_increment,
        uuid varchar(36) not null,
        imcMaximo float,
        imcMinimo float,
        situacao varchar(100) not null,
        primary key (id)
    );

    create table ComponenteAlimentar (
        id bigint not null auto_increment,
        dataCadastro datetime not null,
        quantidade float,
        alimentoUnitario_id bigint not null,
        substancia_id bigint not null,
        primary key (id)
    );

    create table Consulta (
        id bigint not null auto_increment,
        caloriasAlvo float,
        uuid varchar(36) not null,
        dataConsulta datetime not null,
        dataFimVigencia date,
        dataInicioVigencia date,
        altura float,
        peso float,
        imcConsulta float,
        tipoMeta varchar(20),
        valorMeta float,
        diretrizAlimentar_id bigint,
        fatorAtividadeFisica_id bigint,
        planoAlimentar_id bigint not null,
        primary key (id)
    );

    create table DiretrizAlimentar (
        id bigint not null auto_increment,
        dataRevogacao date,
        uuid varchar(36) not null,
        nome varchar(100) not null,
        primary key (id)
    );

    create table DivisaoRefeicao (
        id bigint not null auto_increment,
        uuid varchar(36) not null,
        nome varchar(100) not null,
        primary key (id)
    );

    create table DobraCutanea (
        id bigint not null auto_increment,
        tipoDobra varchar(20) not null,
        valor float not null,
        primary key (id)
    );

    create table EnergiaAlimento (
        id bigint not null auto_increment,
        automatico bit not null,
        dataCadastro datetime not null,
        energia float not null,
        uuid varchar(36) not null,
        alimento_id bigint not null,
        primary key (id)
    );

    create table EnergiaSubstancia (
        id bigint not null auto_increment,
        dataCadastro datetime not null,
        uuid varchar(36) not null,
        fatorEnergetico float,
        substancia_id bigint not null,
        primary key (id)
    );

    create table FatorAtividadeFisica (
        id bigint not null auto_increment,
        atividade varchar(100) not null,
        dataCadastro date not null,
        dataRevogacao date,
        fator float not null,
        uuid varchar(36) not null,
        primary key (id)
    );

    create table FatorMetabolico (
        id bigint not null auto_increment,
        dataCriacao date not null,
        diferencialFeminino integer not null,
        diferencialMasculino integer not null,
        fatorFeminino float not null,
        fatorMasculino float not null,
        uuid varchar(36) not null,
        idadeMaxima integer,
        idadeMinima integer,
        primary key (id)
    );

    create table ItemCardapio (
        id bigint not null auto_increment,
        quantidade float not null,
        energiaAlimento_id bigint not null,
        refeicaoCardapio_id bigint not null,
        tipoApresentacao_id bigint,
        primary key (id)
    );

    create table LimiteEnergetico (
        id bigint not null auto_increment,
        dataCadastro date not null,
        percentualEnergetico float not null,
        tipoRefeicao varchar(8) not null,
        tolerancia float not null,
        divisaoRefeicao_id bigint not null,
        primary key (id)
    );

    create table NormaAlimentar (
        id bigint not null auto_increment,
        dataCriacao date not null,
        normaMaxima float,
        normaMinima float,
        tipoNorma varchar(10) not null,
        diretrizAlimentar_id bigint not null,
        substancia_id bigint not null,
        primary key (id)
    );

    create table Paciente (
        id bigint not null auto_increment,
        dataNascimento date not null,
        nome varchar(100) not null,
        uuid varchar(36) not null,
        tipoCorPele varchar(10) not null,
        tipoSexo varchar(10) not null,
        primary key (id)
    );

    create table PerfilAlimentarPaciente (
        id bigint not null auto_increment,
        dataCadastro date not null,
        uuid varchar(36) not null,
        preferenciaConsumo varchar(15) not null,
        alimento_id bigint,
        categoriaAlimento_id bigint,
        paciente_id bigint not null,
        primary key (id)
    );

    create table PlanoAlimentar (
        id bigint not null auto_increment,
        uuid varchar(36) not null,
        paciente_id bigint not null,
        primary key (id)
    );

    create table RefeicaoCardapio (
        id bigint not null auto_increment,
        tipoRefeicao varchar(9) not null,
        cardapio_id bigint,
        primary key (id)
    );

    create table Substancia (
        id bigint not null auto_increment,
        nome varchar(100) not null,
        ordem integer not null,
        uuid varchar(36) not null,
        unidadeSubstancia varchar(3) not null,
        primary key (id)
    );

    create table TipoApresentacao (
        id bigint not null auto_increment,
        nome varchar(100) not null,
        uuid varchar(36) not null,
        primary key (id)
    );

    create table TipoMedida (
        id bigint not null auto_increment,
        nome varchar(100) not null,
        uuid varchar(36) not null,
        primary key (id)
    );

    alter table AlimentoUnitario 
        add constraint UK_c1bm5fbl9tpbq2dikbndss27d  unique (uuid);

    alter table AlimentoUnitario 
        add constraint UK_tpcuqvmtvwn46gu50diu8jcyq  unique (nome);

    alter table ApresentacaoMedidaAlimento 
        add constraint UK_3crw8ip70gwu7wpted4wm0rmi  unique (uuid);

    alter table Cardapio 
        add constraint UK_7njk4esrp8ebhclyd8trwkmk3  unique (uuid);

    alter table CategoriaAlimento 
        add constraint UK_9iq9ykek4kpk3kd3bh9bmxjss  unique (uuid);

    alter table CategoriaAlimento 
        add constraint UK_biagp9gd1ouulfsjomoe645tg  unique (nome);

    alter table ClassificacaoIMC 
        add constraint UK_qskw9iueuvtqiyhds46d17qie  unique (uuid);

    alter table ClassificacaoIMC 
        add constraint UK_pptsl9tygbi5yxoxmnmrn50tq  unique (situacao);

    alter table Consulta 
        add constraint UK_i815o8jlv3kw206ehxolf9x4e  unique (uuid);

    alter table DiretrizAlimentar 
        add constraint UK_gwh0kmagma6lma68tx77db1kf  unique (uuid);

    alter table DiretrizAlimentar 
        add constraint UK_jx3cyoafr0upx2in07htosvs4  unique (nome);

    alter table DivisaoRefeicao 
        add constraint UK_fs7vnodiuyd57m2qecrc5gpb8  unique (uuid);

    alter table DivisaoRefeicao 
        add constraint UK_1ih3pmmj6e3ej5cgt51nep7nk  unique (nome);

    alter table EnergiaAlimento 
        add constraint UK_qb5iauhwea0l3e79p72wyo8ql  unique (uuid);

    alter table EnergiaSubstancia 
        add constraint UK_k2orytk1744g15afiy7xwu29y  unique (uuid);

    alter table FatorAtividadeFisica 
        add constraint UK_19sjj40h5k9ary1i9kagc6q9e  unique (atividade);

    alter table FatorAtividadeFisica 
        add constraint UK_4l36qo4dd1eiuthd02rhs1d7d  unique (uuid);

    alter table FatorMetabolico 
        add constraint UK_elexg4fbis5b2nofcyoe7nuqa  unique (uuid);

    alter table Paciente 
        add constraint UK_nsm10avbscd4tgsl3bebln6l  unique (uuid);

    alter table PerfilAlimentarPaciente 
        add constraint UK_htjg8ageebnjhhmutol5reg11  unique (uuid);

    alter table PlanoAlimentar 
        add constraint UK_ar59eod6uqmydoyefln98ls53  unique (uuid);

    alter table PlanoAlimentar 
        add constraint UK_p97w7xjxfv4egbyh7cl1yss38  unique (paciente_id);

    alter table Substancia 
        add constraint UK_a7y3j1lou7nwnja4xtvh40cq1  unique (nome);

    alter table Substancia 
        add constraint UK_odesbu140c3p36p4ihjmihrot  unique (uuid);

    alter table TipoApresentacao 
        add constraint UK_esdfrox0chwac8qmf1fxojs7n  unique (nome);

    alter table TipoApresentacao 
        add constraint UK_j89sfwdlvpx9ikpeow3k4mo79  unique (uuid);

    alter table TipoMedida 
        add constraint UK_sv123qwk22xyd4tbatikvqvis  unique (nome);

    alter table TipoMedida 
        add constraint UK_1hghxmd6pdwh550jg1rusfipf  unique (uuid);

    alter table AlimentoUnitario 
        add constraint FK_jsare0nw3155h9kd78o4xah65 
        foreign key (categoriaAlimento_id) 
        references CategoriaAlimento (id);

    alter table ApresentacaoMedidaAlimento 
        add constraint FK_emagndhi2lndvyb4jr2jq92ju 
        foreign key (alimentoGranel_id) 
        references AlimentoUnitario (id);

    alter table ApresentacaoMedidaAlimento 
        add constraint FK_33aamr58fo6dktt0dxwhqikyt 
        foreign key (tipoApresentacao_id) 
        references TipoApresentacao (id);

    alter table ApresentacaoMedidaAlimento 
        add constraint FK_nav90a8wdbibocdiwxb6sw5hb 
        foreign key (tipoMedida_id) 
        references TipoMedida (id);

    alter table Cardapio 
        add constraint FK_bgdgl5vrelh6fqm29335hh187 
        foreign key (consulta_id) 
        references Consulta (id);

    alter table Cardapio 
        add constraint FK_bmklvb2lvxdm3pvdgfadol16i 
        foreign key (divisaoRefeicao_id) 
        references DivisaoRefeicao (id);

    alter table ComponenteAlimentar 
        add constraint FK_fqtwvenpxnwoq8fua9pupoc28 
        foreign key (alimentoUnitario_id) 
        references AlimentoUnitario (id);

    alter table ComponenteAlimentar 
        add constraint FK_ojn11fjwi1ig5bwj5okqjqe43 
        foreign key (substancia_id) 
        references Substancia (id);

    alter table Consulta 
        add constraint FK_5jc0ry39xc9qaj9kyl9keq7f1 
        foreign key (diretrizAlimentar_id) 
        references DiretrizAlimentar (id);

    alter table Consulta 
        add constraint FK_hornbhrur07m72k7a9m9r9ypf 
        foreign key (fatorAtividadeFisica_id) 
        references FatorAtividadeFisica (id);

    alter table Consulta 
        add constraint FK_rpr7k35p3wee421ecp4uu8i50 
        foreign key (planoAlimentar_id) 
        references PlanoAlimentar (id);

    alter table EnergiaAlimento 
        add constraint FK_5teqmivpesf4tc05unyfihuc 
        foreign key (alimento_id) 
        references AlimentoUnitario (id);

    alter table EnergiaSubstancia 
        add constraint FK_5pjhohkm3sq79xr0a78tt9e9k 
        foreign key (substancia_id) 
        references Substancia (id);

    alter table ItemCardapio 
        add constraint FK_m3o9ls0bcgpqlgdtpyl2knig9 
        foreign key (energiaAlimento_id) 
        references EnergiaAlimento (id);

    alter table ItemCardapio 
        add constraint FK_nygwcbgthlvpgje0jrr0jmj9v 
        foreign key (refeicaoCardapio_id) 
        references RefeicaoCardapio (id);

    alter table ItemCardapio 
        add constraint FK_p9an51fjap5b7m531rbdwpj17 
        foreign key (tipoApresentacao_id) 
        references TipoApresentacao (id);

    alter table LimiteEnergetico 
        add constraint FK_da933sk51jr1p4x2tn4fk72ww 
        foreign key (divisaoRefeicao_id) 
        references DivisaoRefeicao (id);

    alter table NormaAlimentar 
        add constraint FK_pmde3p0i1d1mggmp243qut3ov 
        foreign key (diretrizAlimentar_id) 
        references DiretrizAlimentar (id);

    alter table NormaAlimentar 
        add constraint FK_6wuo4r542h4pxohf70bc5he24 
        foreign key (substancia_id) 
        references Substancia (id);

    alter table PerfilAlimentarPaciente 
        add constraint FK_p0h6afffc3gonjwps0cwmcbd9 
        foreign key (alimento_id) 
        references AlimentoUnitario (id);

    alter table PerfilAlimentarPaciente 
        add constraint FK_o4omj3xd6y7a26bo1k7lnn8ht 
        foreign key (categoriaAlimento_id) 
        references CategoriaAlimento (id);

    alter table PerfilAlimentarPaciente 
        add constraint FK_idnj6bhfer2x1ruo2manhukje 
        foreign key (paciente_id) 
        references Paciente (id);

    alter table PlanoAlimentar 
        add constraint FK_p97w7xjxfv4egbyh7cl1yss38 
        foreign key (paciente_id) 
        references Paciente (id);

    alter table RefeicaoCardapio 
        add constraint FK_qdqn51y8h4ka1mugo8k8pcrje 
        foreign key (cardapio_id) 
        references Cardapio (id);
