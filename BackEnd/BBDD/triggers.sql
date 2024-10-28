use notesApp;

DELIMITER //
CREATE TRIGGER history4user
AFTER INSERT
ON `user`
FOR EACH ROW
BEGIN
    INSERT INTO `history` (id_user)
    VALUES (NEW.id);
END;
//
DELIMITER ;