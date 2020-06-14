with results as(
    SELECT host_team as team_id, 3 as points
    FROM matches where host_goals > guest_goals
    UNION
    SELECT guest_team as team_id, 3 as points
    FROM matches where host_goals < guest_goals
    UNION
    SELECT host_team as team_id, 1 as points
    FROM matches where host_goals = guest_goals
    UNION
    SELECT guest_team as team_id, 1 as points
    FROM matches where host_goals = guest_goals
), totals as (
    SELECT team_id, SUM(points) as num_points
    from results
    GROUP BY team_id
)
SELECT t.team_id, t.team_name, COALESCE(totals.num_points, 0) as num_points
FROM teams t LEFT JOIN totals
ON t.team_id = totals.team_id