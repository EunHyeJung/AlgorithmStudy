/*
    @date: 2022.05.13
    @source: https://programmers.co.kr/learn/courses/30/lessons/77487
    @email: ehye826@gmail.com
*/
select pl.*
from
(
    select host_id
    from places
    group by host_id
    having count(*) >= 2
) tmp
inner join places pl on pl.host_id = tmp.host_id
order by pl.id
