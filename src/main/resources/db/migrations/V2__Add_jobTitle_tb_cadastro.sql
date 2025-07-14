-- Migrations to add the JOBTITLE column to the user registration table

ALTER TABLE tb_cadastro
ADD COLUMN job_title VARCHAR(255);