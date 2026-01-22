CREATE TABLE appointments (
    id UUID PRIMARY KEY,
    professional_id UUID NOT NULL,
    client_id UUID NOT NULL,
    start_at TIMESTAMP NOT NULL,
    end_at TIMESTAMP NOT NULL,
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);