db = db.getSiblingDB('ProduktDB'); // switch to or create the database

db.Produkts.insert([
    {
        "name": "testname"
    }
]);
