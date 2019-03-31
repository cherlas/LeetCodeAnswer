###595. Big Countries
```sql
SELECT 
	name, population,area 
FROM 
	World 
WHERE 
	area > 3000000 OR population > 25000000
```

----

###175. Combine Two Tables
```sql
SELECT
	FirstName, LastName, City, State
FROM
	Person
LEFT JOIN
	Address
ON
	Person.personId = Address.PersonId
``