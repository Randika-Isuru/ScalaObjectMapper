CREATE TYPE documents.activity (
    action text,
    user text
);

CREATE TYPE documents.party_id (
    id_type text,
    value text
);

CREATE TABLE documents.document (
    owning_business_party_id text,
    id timeuuid,
    activities frozen<activity>,
    amount int,
    auth_company_id text,
    document_identifier text,
    PRIMARY KEY (owning_business_party_id, id)
);
