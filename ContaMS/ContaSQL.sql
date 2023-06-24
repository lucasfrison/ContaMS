-- Table: public.tb_contasr

-- DROP TABLE IF EXISTS public.tb_contasr;

CREATE TABLE IF NOT EXISTS public.tb_contasr
(
    id_conta integer NOT NULL DEFAULT nextval('tb_contasr_id_conta_seq'::regclass),
    id_cliente integer,
    id_gerente integer,
    numero_conta character varying(255) COLLATE pg_catalog."default",
    saldo_conta numeric,
    limite_conta numeric,
    criacao_conta date,
    CONSTRAINT tb_contasr_pkey PRIMARY KEY (id_conta)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tb_contasr
    OWNER to bantads;

-- Table: public.tb_movimentacoesr

-- DROP TABLE IF EXISTS public.tb_movimentacoesr;

CREATE TABLE IF NOT EXISTS public.tb_movimentacoesr
(
    id_mov integer NOT NULL DEFAULT nextval('tb_movimentacoesr_id_mov_seq'::regclass),
    data_mov date,
    tipo_mov character varying(255) COLLATE pg_catalog."default",
    valor_mov numeric,
    id_origem integer,
    id_destino integer,
    CONSTRAINT tb_movimentacoesr_pkey PRIMARY KEY (id_mov),
    CONSTRAINT tb_movimentacoesr_id_destino_fkey FOREIGN KEY (id_destino)
        REFERENCES public.tb_contasr (id_conta) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT tb_movimentacoesr_id_origem_fkey FOREIGN KEY (id_origem)
        REFERENCES public.tb_contasr (id_conta) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tb_movimentacoesr
    OWNER to bantads;

-- Table: public.tb_contascud

-- DROP TABLE IF EXISTS public.tb_contascud;

CREATE TABLE IF NOT EXISTS public.tb_contascud
(
    id_conta integer NOT NULL DEFAULT nextval('tb_contascud_id_conta_seq'::regclass),
    id_cliente integer,
    id_gerente integer,
    numero_conta character varying(255) COLLATE pg_catalog."default",
    saldo_conta numeric,
    limite_conta numeric,
    criacao_conta date,
    CONSTRAINT tb_contascud_pkey PRIMARY KEY (id_conta)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tb_contascud
    OWNER to bantads;

-- Table: public.tb_movimentacoescud

-- DROP TABLE IF EXISTS public.tb_movimentacoescud;

CREATE TABLE IF NOT EXISTS public.tb_movimentacoescud
(
    id_mov integer NOT NULL DEFAULT nextval('tb_movimentacoescud_id_mov_seq'::regclass),
    data_mov date,
    tipo_mov character varying(255) COLLATE pg_catalog."default",
    valor_mov numeric,
    id_origem integer,
    id_destino integer,
    CONSTRAINT tb_movimentacoescud_pkey PRIMARY KEY (id_mov),
    CONSTRAINT tb_movimentacoescud_id_destino_fkey FOREIGN KEY (id_destino)
        REFERENCES public.tb_contascud (id_conta) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT tb_movimentacoescud_id_origem_fkey FOREIGN KEY (id_origem)
        REFERENCES public.tb_contascud (id_conta) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tb_movimentacoescud
    OWNER to bantads;
