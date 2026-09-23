ALTER TABLE IF EXISTS city ADD COLUMN IF NOT EXISTS timezone_id VARCHAR(64);
UPDATE city SET timezone_id = 'Asia/Novosibirsk' WHERE name_ = 'Новосибирск';
UPDATE city SET timezone_id = 'Asia/Barnaul' WHERE name_ = 'Барнаул';