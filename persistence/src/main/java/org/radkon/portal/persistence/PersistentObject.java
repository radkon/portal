package org.radkon.portal.persistence;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.UUID;

/**
 * Basis für einfache Entitäten. Beim Erstellen eines {@link PersistentObject}s wird eine ID vergeben. Zusammen mit
 * der bereitgestellten Implementierung von <code>hashCode()</code> und <code>equals()</code> ist sichergestellt,
 * dass die Verwendung eines {@link PersistentObject}s in Hash-basierten Collections sicher ist.
 *
 * @author Markus Konrad, PRODYNA AG
 */
@MappedSuperclass
public abstract class PersistentObject implements Serializable {

    private static final long serialVersionUID = 2745063100347034780L;

    private String id;

    private Long version;

    protected PersistentObject() {
        setId(UUID.randomUUID().toString());
    }

    @Id
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Version
    private Long getVersion() {
        return version;
    }

    private void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersistentObject)) return false;

        PersistentObject that = (PersistentObject) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "PersistentObject{" +
                "id='" + id + '\'' +
                ", version=" + version +
                '}';
    }
}
