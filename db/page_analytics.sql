CREATE SCHEMA page_analytics_schema;
COMMIT;

create table page_views(
  page_id varchar,
  page_views int,
  event_history json
)
