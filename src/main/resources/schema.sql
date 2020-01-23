DROP TABLE IF EXISTS search_terms;
 

CREATE TABLE search_terms (
  id INTEGER AUTO_INCREMENT  PRIMARY KEY,
  country VARCHAR(250) NOT NULL,
  customer_id INTEGER NOT NULL,
  search_term VARCHAR(250) NOT NULL,
  score INTEGER NOT NULL,
  report_date DATE NOT NULL
);