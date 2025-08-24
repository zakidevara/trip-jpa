SELECT * FROM FLIGHT_ROUTE AS route
LEFT JOIN FLIGHT_ROUTE_SEGMENTS AS route_segment ON route.ID=route_segment.flight_route_id
LEFT JOIN FLIGHT_SEGMENT AS segment ON route_segment.segments_id=segment.id
WHERE route.ID='JFK.LAX.AA.ECONOMY.2023-12-01.17:00.2023-12-01.20:00';