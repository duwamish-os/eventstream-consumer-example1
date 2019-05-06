CREATE SCHEMA page_analytics_schema;
COMMIT;

CREATE TABLE page_views(
  page_id varchar,
  page_views int,
  event_history json
);

COMMIT;