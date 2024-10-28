use notesApp;

DELIMITER //
CREATE TRIGGER createUserHistory
AFTER INSERT ON `user`
FOR EACH ROW
BEGIN
    INSERT INTO `history` (action, table_affected, column_affected, description)
    VALUES ('CREATE', 'user', '*', CONCAT('User ID: ', NEW.id, ' has created an account.'));
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER createNoteHistory
AFTER INSERT ON `note`
FOR EACH ROW
BEGIN
    INSERT INTO `history` (action, table_affected, column_affected, description)
    VALUES ('CREATE', 'note', '*', CONCAT('User ID: ', NEW.id_user, ' created a new note with ID: ', NEW.id, '.'));
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER updateUserHistory
AFTER UPDATE ON user
FOR EACH ROW
BEGIN
    DECLARE changes VARCHAR(255) DEFAULT '';

    IF NEW.username != OLD.username THEN
        SET changes = CONCAT(changes, 'username, ');
    END IF;

    IF NEW.password != OLD.password THEN
        SET changes = CONCAT(changes, 'password, ');
    END IF;

    -- Solo inserta si hubo cambios
    IF changes != '' THEN
        -- Elimina la última coma y espacio
        SET changes = TRIM(TRAILING ', ' FROM changes);

        INSERT INTO history (action, table_affected, column_affected, description)
        VALUES ('UPDATE', 'user', changes, CONCAT('User ID: ', NEW.id, ' modified their ', changes, '.'));
    END IF;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER updateNoteHistory
AFTER UPDATE ON note
FOR EACH ROW
BEGIN
    DECLARE changes VARCHAR(255) DEFAULT '';

    IF NEW.title != OLD.title THEN
        SET changes = CONCAT(changes, 'title, ');
    END IF;

    IF NEW.content != OLD.content THEN
        SET changes = CONCAT(changes, 'content, ');
    END IF;

    -- Solo inserta si hubo cambios
    IF changes != '' THEN
        -- Elimina la última coma y espacio
        SET changes = TRIM(TRAILING ', ' FROM changes);

        INSERT INTO history (action, table_affected, column_affected, description)
        VALUES ('UPDATE', 'note', changes, CONCAT('User ID: ', NEW.id_user, ' updated note with ID: ', NEW.id, ' on ',changes,"."));
    END IF;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER deleteUserHistory
AFTER DELETE ON `user`
FOR EACH ROW
BEGIN
    INSERT INTO `history` (action, table_affected, column_affected, description)
    VALUES ('DELETE', 'user', '*', CONCAT('User ID: ', OLD.id, ' deleted user with ID: ', OLD.id, '.'));
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER deleteNoteHistory
AFTER DELETE ON `note`
FOR EACH ROW
BEGIN
    INSERT INTO `history` (action, table_affected, column_affected, description)
    VALUES ('DELETE', 'note', '*', CONCAT('User ID: ', OLD.id_user, ' deleted note with ID: ', OLD.id, '.'));
END;
//
DELIMITER ;