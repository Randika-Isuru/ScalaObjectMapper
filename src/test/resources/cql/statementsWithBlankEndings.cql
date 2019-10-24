CREATE TYPE documents_sample.activity (
    action text,
    user text
);

CREATE TYPE documents_sample.party_id (
    id_type text,
    value text
);

CREATE TABLE documents_sample.document (
    owning_business_party_id text,
    id timeuuid,
    activities frozen<activity>,
    amount int,
    auth_company_id text,
    document_identifier text,
    party_ids SET<int>,
    activity_set SET<frozen <activity>>,
    PRIMARY KEY (owning_business_party_id, id)
);
