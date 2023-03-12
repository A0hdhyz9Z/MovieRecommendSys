import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Worker(
    @Id
    var id: Int = 0
)
