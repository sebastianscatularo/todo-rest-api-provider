FORMAT: 1A

#TODO Dashboard API
An dashboard with trasks to do.

# Users [/users]

## All users [GET]

+ Response 200 (application/json)

        [
            {
                "id": 1,
                "email": "jhon.doe@dashboard.com",
                "password": "xxxxxx",
                "links":    [
                    {
                        "rel": "self",
                        "/users/1"
                    },
                    {
                        "dashboards",
                        "/users/1/dashboards"
                    }
                ]
            }
        ]

# Dashboards [/dashboards]

## All allowed dashboards [GET]

+ Response 200 (application/json)

        [
            {
                "id": 1,
                "name": "dashboard name",
                "links": [
                    {
                        "rel": "self",
                        "/dashboards/1"
                    },
                    {
                        "rel": "tasks",
                        "/dashboards/1/tasks"
                    }
                ]
                                
            }
        ]