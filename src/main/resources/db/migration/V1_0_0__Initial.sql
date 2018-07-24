CREATE TABLE loaner
(
    id character varying(255) NOT NULL,
    address character varying(255),
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    phone character varying(255),
    CONSTRAINT loaner_pkey PRIMARY KEY (id)
);

CREATE TABLE item
(
    id SERIAL,
    description character varying(255),
    status character varying(255),
    owner_id character varying(255),
    CONSTRAINT item_pkey PRIMARY KEY (id),
    CONSTRAINT fk_item_loaner FOREIGN KEY (owner_id)
        REFERENCES loaner (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE TABLE loan
(
    id SERIAL,
    return_date timestamp without time zone,
    return_until timestamp without time zone,
    start_date timestamp without time zone,
    holder_id character varying(255),
    item_id integer,
    CONSTRAINT loan_pkey PRIMARY KEY (id),
    CONSTRAINT fk_loan_loaner FOREIGN KEY (holder_id)
        REFERENCES loaner (id) MATCH SIMPLE
        ON UPDATE SET NULL
        ON DELETE SET NULL,
    CONSTRAINT fk_loan_item FOREIGN KEY (item_id)
        REFERENCES item (id) MATCH SIMPLE
        ON UPDATE SET NULL
        ON DELETE SET NULL
);