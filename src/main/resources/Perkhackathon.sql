--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.2
-- Dumped by pg_dump version 9.4.2
-- Started on 2015-12-19 19:48:15

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2042 (class 1262 OID 12135)
-- Dependencies: 2041
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 182 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2045 (class 0 OID 0)
-- Dependencies: 182
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 181 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2046 (class 0 OID 0)
-- Dependencies: 181
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 180 (class 1259 OID 16435)
-- Name: points_earn; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE points_earn (
    points_earn_id integer NOT NULL,
    point_by_user bigint NOT NULL,
    points_type smallint NOT NULL,
    point_val integer NOT NULL,
    point_calc_from_post_id bigint
);


ALTER TABLE points_earn OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 16433)
-- Name: points_earn_points_earn_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE points_earn_points_earn_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE points_earn_points_earn_id_seq OWNER TO postgres;

--
-- TOC entry 2047 (class 0 OID 0)
-- Dependencies: 179
-- Name: points_earn_points_earn_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE points_earn_points_earn_id_seq OWNED BY points_earn.points_earn_id;


--
-- TOC entry 178 (class 1259 OID 16427)
-- Name: post_association; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE post_association (
    post_association_id integer NOT NULL,
    question_post_id bigint NOT NULL,
    answer_post_id bigint NOT NULL
);


ALTER TABLE post_association OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 16425)
-- Name: post_association_post_association_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE post_association_post_association_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE post_association_post_association_id_seq OWNER TO postgres;

--
-- TOC entry 2048 (class 0 OID 0)
-- Dependencies: 177
-- Name: post_association_post_association_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE post_association_post_association_id_seq OWNED BY post_association.post_association_id;


--
-- TOC entry 176 (class 1259 OID 16416)
-- Name: posts; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE posts (
    post_id integer NOT NULL,
    posted_by bigint NOT NULL,
    post_content character(1000) NOT NULL,
    post_type smallint
);


ALTER TABLE posts OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16414)
-- Name: posts_post_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE posts_post_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE posts_post_id_seq OWNER TO postgres;

--
-- TOC entry 2049 (class 0 OID 0)
-- Dependencies: 175
-- Name: posts_post_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE posts_post_id_seq OWNED BY posts.post_id;


--
-- TOC entry 172 (class 1259 OID 16393)
-- Name: sample; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sample (
    sampleid bigint NOT NULL,
    sample_name character varying(50)
);


ALTER TABLE sample OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16408)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    user_id integer NOT NULL,
    user_name character(50) NOT NULL,
    user_password character(50) NOT NULL,
    first_name character(50),
    last_name character(50),
    city character(50),
    state character(50)
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16406)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_user_id_seq OWNER TO postgres;

--
-- TOC entry 2050 (class 0 OID 0)
-- Dependencies: 173
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_user_id_seq OWNED BY users.user_id;


--
-- TOC entry 1908 (class 2604 OID 16438)
-- Name: points_earn_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY points_earn ALTER COLUMN points_earn_id SET DEFAULT nextval('points_earn_points_earn_id_seq'::regclass);


--
-- TOC entry 1907 (class 2604 OID 16430)
-- Name: post_association_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post_association ALTER COLUMN post_association_id SET DEFAULT nextval('post_association_post_association_id_seq'::regclass);


--
-- TOC entry 1906 (class 2604 OID 16419)
-- Name: post_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY posts ALTER COLUMN post_id SET DEFAULT nextval('posts_post_id_seq'::regclass);


--
-- TOC entry 1905 (class 2604 OID 16411)
-- Name: user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN user_id SET DEFAULT nextval('users_user_id_seq'::regclass);


--
-- TOC entry 2036 (class 0 OID 16435)
-- Dependencies: 180
-- Data for Name: points_earn; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY points_earn (points_earn_id, point_by_user, points_type, point_val, point_calc_from_post_id) FROM stdin;
\.


--
-- TOC entry 2051 (class 0 OID 0)
-- Dependencies: 179
-- Name: points_earn_points_earn_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('points_earn_points_earn_id_seq', 1, false);


--
-- TOC entry 2034 (class 0 OID 16427)
-- Dependencies: 178
-- Data for Name: post_association; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY post_association (post_association_id, question_post_id, answer_post_id) FROM stdin;
\.


--
-- TOC entry 2052 (class 0 OID 0)
-- Dependencies: 177
-- Name: post_association_post_association_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('post_association_post_association_id_seq', 1, false);


--
-- TOC entry 2032 (class 0 OID 16416)
-- Dependencies: 176
-- Data for Name: posts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY posts (post_id, posted_by, post_content, post_type) FROM stdin;
6	2	mycontent                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               	1
\.


--
-- TOC entry 2053 (class 0 OID 0)
-- Dependencies: 175
-- Name: posts_post_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('posts_post_id_seq', 6, true);


--
-- TOC entry 2028 (class 0 OID 16393)
-- Dependencies: 172
-- Data for Name: sample; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sample (sampleid, sample_name) FROM stdin;
1	satya
\.


--
-- TOC entry 2030 (class 0 OID 16408)
-- Dependencies: 174
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (user_id, user_name, user_password, first_name, last_name, city, state) FROM stdin;
1	satya                                             	satya                                             	satya                                             	moha                                              	bangalore                                         	karnataka                                         
2	karnataka1                                        	moha1                                             	satya1                                            	satya1                                            	satya1                                            	bangalore1                                        
\.


--
-- TOC entry 2054 (class 0 OID 0)
-- Dependencies: 173
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_user_id_seq', 2, true);


--
-- TOC entry 1918 (class 2606 OID 16440)
-- Name: points_earn_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY points_earn
    ADD CONSTRAINT points_earn_pkey PRIMARY KEY (points_earn_id);


--
-- TOC entry 1916 (class 2606 OID 16432)
-- Name: post_association_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY post_association
    ADD CONSTRAINT post_association_pkey PRIMARY KEY (post_association_id);


--
-- TOC entry 1914 (class 2606 OID 16424)
-- Name: posts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY posts
    ADD CONSTRAINT posts_pkey PRIMARY KEY (post_id);


--
-- TOC entry 1910 (class 2606 OID 16397)
-- Name: sample_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sample
    ADD CONSTRAINT sample_pk PRIMARY KEY (sampleid);


--
-- TOC entry 1912 (class 2606 OID 16413)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2044 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-12-19 19:48:15

--
-- PostgreSQL database dump complete
--

