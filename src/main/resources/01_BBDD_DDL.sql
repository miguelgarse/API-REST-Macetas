
--
-- PostgreSQL DDL Tables creation
-- 15/01/2021
--

CREATE TABLE public.action (
    id bigint NOT NULL,
    action_desc character varying(255)
);


ALTER TABLE public.action OWNER TO postgres;

CREATE SEQUENCE public.action_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.action_id_seq OWNER TO postgres;

ALTER SEQUENCE public.action_id_seq OWNED BY public.action.id;


CREATE TABLE public.client (
    id bigint NOT NULL,
    descripcion character varying(255),
    letra character varying(255),
    thingsboard_id character varying(255)
);

ALTER TABLE public.client OWNER TO postgres;


CREATE SEQUENCE public.client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.client_id_seq OWNER TO postgres;

ALTER SEQUENCE public.client_id_seq OWNED BY public.client.id;

CREATE TABLE public.events (
    id bigint NOT NULL,
    "timestamp" timestamp without time zone,
    action_id bigint,
    cliente_id bigint
);

ALTER TABLE public.events OWNER TO postgres;


CREATE SEQUENCE public.events_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.events_id_seq OWNER TO postgres;

ALTER SEQUENCE public.events_id_seq OWNED BY public.events.id;

CREATE TABLE public.sensor (
    id bigint NOT NULL,
    nombre character varying(255),
    tipo_sensor_id bigint
);


ALTER TABLE public.sensor OWNER TO postgres;


CREATE TABLE public.sensor_client (
    id bigint NOT NULL,
    cliente_id bigint,
    sensor_id bigint
);


ALTER TABLE public.sensor_client OWNER TO postgres;

CREATE SEQUENCE public.sensor_client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sensor_client_id_seq OWNER TO postgres;

ALTER SEQUENCE public.sensor_client_id_seq OWNED BY public.sensor_client.id;

CREATE SEQUENCE public.sensor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.sensor_id_seq OWNER TO postgres;


ALTER SEQUENCE public.sensor_id_seq OWNED BY public.sensor.id;


CREATE TABLE public.sensor_type (
    id bigint NOT NULL,
    descripcion character varying(255),
    nombre character varying(255)
);


ALTER TABLE public.sensor_type OWNER TO postgres;

CREATE SEQUENCE public.sensor_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sensor_type_id_seq OWNER TO postgres;


ALTER SEQUENCE public.sensor_type_id_seq OWNED BY public.sensor_type.id;


CREATE SEQUENCE public.seq_afic
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_afic OWNER TO postgres;


CREATE TABLE public.timeline (
    id bigint NOT NULL,
    "timestamp" timestamp without time zone,
    valor character varying(255),
    sensor_id bigint
);


ALTER TABLE public.timeline OWNER TO postgres;

CREATE SEQUENCE public.timeline_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.timeline_id_seq OWNER TO postgres;


ALTER SEQUENCE public.timeline_id_seq OWNED BY public.timeline.id;

CREATE TABLE public.users (
    id bigint NOT NULL,
    pass character varying(255),
    usuario character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;


CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


-- SEQUENCE ASSOCIATION

ALTER TABLE ONLY public.action ALTER COLUMN id SET DEFAULT nextval('public.action_id_seq'::regclass);

ALTER TABLE ONLY public.client ALTER COLUMN id SET DEFAULT nextval('public.client_id_seq'::regclass);

ALTER TABLE ONLY public.events ALTER COLUMN id SET DEFAULT nextval('public.events_id_seq'::regclass);

ALTER TABLE ONLY public.sensor ALTER COLUMN id SET DEFAULT nextval('public.sensor_id_seq'::regclass);

ALTER TABLE ONLY public.sensor_client ALTER COLUMN id SET DEFAULT nextval('public.sensor_client_id_seq'::regclass);

ALTER TABLE ONLY public.sensor_type ALTER COLUMN id SET DEFAULT nextval('public.sensor_type_id_seq'::regclass);

ALTER TABLE ONLY public.timeline ALTER COLUMN id SET DEFAULT nextval('public.timeline_id_seq'::regclass);

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


-- PRIMARY KEYS

ALTER TABLE ONLY public.action
    ADD CONSTRAINT action_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.sensor_client
    ADD CONSTRAINT sensor_client_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.sensor
    ADD CONSTRAINT sensor_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.sensor_type
    ADD CONSTRAINT sensor_type_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.timeline
    ADD CONSTRAINT timeline_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


-- FOREIGN KEYS

ALTER TABLE ONLY public.timeline
    ADD CONSTRAINT fk2y3x8q0kf46gryio48pcbu11r FOREIGN KEY (sensor_id) REFERENCES public.sensor(id);


ALTER TABLE ONLY public.sensor
    ADD CONSTRAINT fk3uiv8n24u3j5nda80ubqgx2f7 FOREIGN KEY (tipo_sensor_id) REFERENCES public.sensor_type(id);


ALTER TABLE ONLY public.sensor_client
    ADD CONSTRAINT fkantpo052c0dh2xwu8422rl6s0 FOREIGN KEY (sensor_id) REFERENCES public.sensor(id);

ALTER TABLE ONLY public.events
    ADD CONSTRAINT fkd61eriitppc5hb9bekks4f8gk FOREIGN KEY (action_id) REFERENCES public.action(id);


ALTER TABLE ONLY public.events
    ADD CONSTRAINT fkjgsgr097fvfxgol8p3na0wygd FOREIGN KEY (cliente_id) REFERENCES public.client(id);


ALTER TABLE ONLY public.sensor_client
    ADD CONSTRAINT fkpbw3c61qrrbb7n8lk2dnu3sy2 FOREIGN KEY (cliente_id) REFERENCES public.client(id);



