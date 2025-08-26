
INSERT INTO Client (name) VALUES
                              ('John Smith'),
                              ('Alice Johnson'),
                              ('Robert Brown'),
                              ('Emily Davis'),
                              ('Michael Wilson'),
                              ('Sophia Taylor'),
                              ('James Anderson'),
                              ('Olivia Thomas'),
                              ('Daniel White'),
                              ('Emma Harris');


INSERT INTO Planet (id, name) VALUES
                                  ('MERC', 'Mercury'),
                                  ('VEN',  'Venus'),
                                  ('EARTH','Earth'),
                                  ('MARS', 'Mars'),
                                  ('JUP',  'Jupiter');


INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES
                                                                 (1, 'EARTH', 'MARS'),
                                                                 (2, 'MARS', 'EARTH'),
                                                                 (3, 'EARTH', 'VEN'),
                                                                 (4, 'VEN', 'JUP'),
                                                                 (5, 'MERC', 'EARTH'),
                                                                 (6, 'EARTH', 'JUP'),
                                                                 (7, 'JUP', 'MARS'),
                                                                 (8, 'MARS', 'VEN'),
                                                                 (9, 'VEN', 'EARTH'),
                                                                 (10, 'EARTH', 'MERC');